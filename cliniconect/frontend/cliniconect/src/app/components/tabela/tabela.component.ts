import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ApiService } from 'src/app/service/api.service';
import { NgbModalConfig, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-tabela',
  templateUrl: './tabela.component.html',
  styleUrls: ['./tabela.component.scss']
})
export class TabelaComponent implements OnInit {

  formulario: FormGroup;
  pessoas: Array<any>;
  item:any
  ps: Number = 1 ;
  count : Number = 5;

  constructor(private apiService:ApiService,
    private formBuilder: FormBuilder,
    config: NgbModalConfig, private modalService: NgbModal) { 
      config.backdrop = 'static';
      config.keyboard = false;
    }

  ngOnInit() {
    this.listar();
  }

  listar(){
    this.apiService.listar().subscribe(dados => this.pessoas = dados);
  }

  open(content,value:any) {
    this.item = value
    this.modalService.open(content);
    
    this.configurarFormulario();
  }

  

  editar(content){
    this.apiService.criar(this.formulario.value).subscribe(resposta => {
      this.pessoas[this.pessoas.indexOf(this.item)] = resposta;
      this.modalService.dismissAll(content)
      this.formulario.reset();
    });
  }

  deletar(value:any){
    this.apiService.deletar(value).subscribe(
      resposta => {
        this.pessoas.splice(this.pessoas.indexOf(value),1);
      }
    );
  }

  configurarFormulario(){
    this.formulario = this.formBuilder.group({
      nome: [this.item.nome, Validators.required],
      sexo: [this.item.sexo, Validators.required],
      celular: [this.item.celular, Validators.required],
      cpf: [this.item.cpf, Validators.required],
      dtNasc: [this.item.dtNasc, Validators.required],
      email: [this.item.email, Validators.required],
      endereco: [this.item.endereco, Validators.required,null, Validators.email]
    });
  }
}
