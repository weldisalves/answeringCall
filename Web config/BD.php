<?php

	class BD{
		private $conexao;
		private $link;
		private $login;
		private $senha;
		private $nomeBanco;
		
		public BD($con, $link, $login, $senha, $nomeBanco){
			this->
	$conexao=mysql_connect ("localhost", " LOGIN", "SENHA");
	mysql_select_db("NOME DO BANCO", $conexao);
	mysql_query("insert into NOME DA TABELA values “('$CAMPO DA TEABELA')",$conexao);
?>
