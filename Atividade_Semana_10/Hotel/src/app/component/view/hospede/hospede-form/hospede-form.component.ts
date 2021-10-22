import { HotelService } from '../../../../Service/Hotel.service';
import { Hotel } from '../../../../Model/hotel.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hospede-form',
  templateUrl: './hospede-form.component.html',
  styleUrls: ['./hospede-form.component.css']
})
export class HospedeFormComponent implements OnInit {

  titulo: string = "Cadastrar novo Hospede";

  hospede: Hospede = {
    nmHospede : "",
    cpf: 0,
    dtNascimento: 0
  }

  constructor(
    private service: HospedeService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  salvar(): void {
    this.service.create(this.hospede).subscribe(() =>{
      this.service.showMessage("Hospede cadastro com sucesso!")
      this.router.navigate(['/hospedes']);
    });
  }

}