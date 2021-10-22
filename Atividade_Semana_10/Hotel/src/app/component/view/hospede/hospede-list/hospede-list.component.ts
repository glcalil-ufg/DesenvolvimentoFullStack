import { ConfirmDeleteComponent } from '../../../template/confirm-delete/confirm-delete.component';
import { HotelService } from '../../../../Service/Hospede.service';
import { Component, OnInit } from '@angular/core';
import { Hospede } from 'src/app/Model/hospede.model';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-hospede-list',
  templateUrl: './hospede-list.component.html',
  styleUrls: ['./hospede-list.component.css']
})
export class HospedeListComponent implements OnInit {

  hospede: Hospede[] = [];
  displayedColumns: string[] = ['id', 'nome', 'dtNascimento', 'cpf', 'acao'];
  constructor(
    private service : HotelService,
    private dialog: MatDialog
  ) { }

  atualizarDados(): void {
    this.service.findAll().subscribe(hospede => {
      this.hospede = hospede;
    });
  }

  ngOnInit(): void {
    this.atualizarDados();
  }

  excluir(hospede: Hospede): void{

    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: `Deseja realmente excluir o hospede ${hospede.nmHospede}?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Desistir'
        }
      }
    })

    dialogRef.afterClosed().subscribe((confirm: boolean) =>{
      if(confirm){
        this.service.delete(hospede).subscribe(() => {
          this.service.showMessage("Hospede excluído com sucesso!");
          this.atualizarDados();
        });
      }
    })
    
  }

}