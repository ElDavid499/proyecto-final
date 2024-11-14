import { Component } from '@angular/core';
import { Deporte } from './deporte';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { DeportesService } from './deporte.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, CommonModule], 
  templateUrl: './form.component.html'
})
export class FormComponent {
  public deporte:Deporte = new Deporte()

  titulo: string = "Formulario de Ingreso de Deporte";

  constructor(
    private deportesService: DeportesService,
    private router: Router,
    private activatedRoute: ActivatedRoute  ) {}

  ngOnInit(): void {
    this.cargarDeporte();
  }

  // Cargar el deporte actual si tiene un ID
  cargarDeporte(): void {
    this.activatedRoute.params.subscribe(params => {
      let id = params['id'];
      if (id) {
        this.deportesService.getDeporte(id).subscribe(deporte => this.deporte = deporte);
      }
    });
  }

  // Actualizar deporte
  update(): void {
    this.deportesService.update(this.deporte).subscribe(deporte => {
      this.router.navigate(['/deportes']);
      Swal.fire('Deporte Actualizado', `Deporte: ${deporte.nombre} actualizado con éxito!`, 'success');
    });
  }

  // Crear nuevo deporte
  public create(): void {
    console.log(this.deporte);
    this.deportesService.create(this.deporte).subscribe(deporte => {
      this.router.navigate(['/deportes']);
      Swal.fire('Nuevo Deporte', `Deporte: ${deporte.nombre} creado con éxito`, 'success');
    });
  }
}
