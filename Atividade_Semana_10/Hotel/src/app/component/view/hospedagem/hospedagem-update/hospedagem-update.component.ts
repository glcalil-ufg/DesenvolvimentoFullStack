import { Hospedagem } from './../../../../Model/hospedagem.model';
import { HospedagemService } from './../../../../Service/Hospedagem.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-hospedagem-update',
  templateUrl: './../hospedagem-form/hospedagem-form.component.html',
  styleUrls: ['./../hospedagem-form/hospedagem-form.component.css']
})
export class HospedagemUpdateComponent implements OnInit {

  titulo: string = "Alterar dados do Hospedagem";

  hospedagem: Hospedagem = {
    idQuarto : 0,
    idHospede: 0,
    dtCheckin: 0,
    dtCheckout: 0
  }
  constructor(
    private route: ActivatedRoute,
    private service: HospedagemService,
    private router: Router
  ) { }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    if(id != null){
      this.service.findById(id).subscribe(hospedagem => {
        this.hospedagem = hospedagem;
      })
    }
  }

  salvar(): void {
    this.service.update(this.hospedagem).subscribe(() =>{
      this.service.showMessage("Hospedagem atualizado sucesso!")
      this.router.navigate(['/hospedagems']);
    });
  }
}