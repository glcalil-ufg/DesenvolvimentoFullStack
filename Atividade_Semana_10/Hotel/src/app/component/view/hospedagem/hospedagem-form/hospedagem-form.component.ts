import { HospedagemService } from '../../../../Service/Hospedagem.service';
import { Hospedagem } from '../../../../Model/hospedagem.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hospedagem-form',
  templateUrl: './hospedagem-form.component.html',
  styleUrls: ['./hospedagem-form.component.css']
})
export class HospedagemFormComponent implements OnInit {

  titulo: string = "Cadastrar novo Hospedagem";

  hospedagem: Hospedagem = {
    idQuarto : 0,
    idHospede: 0,
    dtCheckin: 0,
    dtCheckout: 0
  }

  constructor(
    private service: HospedagemService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  salvar(): void {
    this.service.create(this.hospedagem).subscribe(() =>{
      this.service.showMessage("Hospedagem cadastrada com sucesso!")
      this.router.navigate(['/hospedagens']);
    });
  }

}