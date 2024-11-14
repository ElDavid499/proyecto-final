import { Component, OnInit } from '@angular/core';
import { Deporte } from './deporte';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { DeportesService } from './deporte.service';



@Component({
  selector: 'app-deportes',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './deporte.component.html',
  styleUrl: './deporte.component.css'
})
export class DeporteComponent implements OnInit {
  
  deporte:Deporte[];

  constructor(private deportesService: DeportesService){

  }
  
  ngOnInit(): void {
    this.deportesService.getDeportes().subscribe(
      deportes => this.deporte = deportes
    )
  }

  //invocando el método de eliminar
  delete(deporte:Deporte):void{
    Swal.fire({
      title: "Esta segur@?",
      text: `Seguro deseas eliminar el Deporte: ${deporte.nombre} !`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, Eliminar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.deportesService.delete(deporte.id).subscribe(
          ()=>{
            this.deporte = this.deporte.filter(tar=> tar !== deporte)
            Swal.fire({
              title: "Borrada!",
              text: `Tu   Deporte ha sido eliminada: ${deporte.nombre}`,
              icon: "success"
            });
          }
        )
      }
    });
  }

}
