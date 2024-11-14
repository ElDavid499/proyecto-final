import { Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ResponsablesComponent } from './responsables/responsables.component';
import { FormComponent } from './deportes/form.component';
import { DeporteComponent } from './deportes/deporte.component';

export const routes: Routes = [
    {path:'', redirectTo:'/deportes', pathMatch:'full'},
    {path:'deportes', component:DeporteComponent},
    {path:'header', component: HeaderComponent},
    {path:'footer', component:FooterComponent},
    {path:'responsables', component:ResponsablesComponent},
    {path:'deportes/form', component:FormComponent},
    {path:'deportes/form/:id', component:FormComponent},
];
