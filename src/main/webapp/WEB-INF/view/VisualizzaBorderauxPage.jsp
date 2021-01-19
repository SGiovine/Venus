<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Srl Group</title>

<style type="text/css">
body {
	background: linear-gradient(to bottom, rgb(39, 40, 58), rgb(10, 10, 10));
	background-attachment: fixed;
	background-size: cover;
	background-repeat: no-repeat;
}

.btn-menu {
	margin: 0 0 0 5%;
	width: 170px;
	height: 20px;
}

.search {
	margin: 30px auto 0 auto;
	width: 170px;
	height: 20px;
}

.genera-cancella {
	margin: 10px auto 0 auto;
	width: 170px;
	height: 20px;
}

.border-container {
	max-width: 95%;
	padding: 4px 6px 4px 6px;
	background: linear-gradient(to right, rgb(212, 0, 0), rgb(212, 64, 0));
	border-radius: 5px 5px 5px 5px;
	margin: 10px auto 0 auto;
}

.container {
	position: relative;
	background: rgb(245, 242, 200);
	border-radius: 5px 5px 5px 5px;
	padding: 2px 0px 2px;
	width: 100%;
}

th {
	background: rgb(137, 0, 0);
	color: white;
	word-break: break-all;
}

td {
	border: 1px solid black;
	text-align: center;
	word-break: break-all;
	weight: 100;
}

table {
	border-collapse: collapse;
	table-layout: fixed;
	width: 100%;
}

.checkboxes {
	
}

#pageInput {
	width: 50%;
	min-width: 30px;
}

.back-forward {
	margin: 4px auto 2px auto;
	display: flex;
	justify-content: space-between;
	width: 65%;
	min-width: 50%;
}

.switch-pages {
	position: relative;
	height: 50%;
	margin: auto, auto, auto, auto;
}

.number-pages {
	display: flex;
	display-direction: row;
	flex-grow: 3;
	justify-content: space-between;
}

.pageButtons {
	background: none;
	border: none;
}
</style>

<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<script>

	var pagSelected=0;
	var insiemePagine = new Array();
	var tipoRegistro = "LI";
	
	function tableBuilder(){
		
		var table = document.getElementById("table");
		var bodyT = "<table><tr><th><input type=\"checkbox\" onclick=\"getThemAll(this)\"></th><th><p>data</p></th><th><p>note</p></th><th><p>codice</p></th><th><p>localita</p></th><th><p>indirizzo</p></th><th><p>provincia</p></th><th><p>cap</p></th><th><p>ragione<br> sociale</p></th><th><p>ragione<br> soc 2</p></th><th><p>aspetto</p></th><th><p>peso</p></th></tr>";

		console.log("tablebuilder, pagSelected= "+pagSelected);
		
		if(pagSelected > insiemePagine.length-1){
			pagSelected = insiemePagine.length;
		} else if (pagSelected < 0){
			pagSelected=0;
		}

		console.log("tablebuilder, pagSelectedCorrection= "+pagSelected);
		
		if(insiemePagine != 0){
		
		insiemePagine[pagSelected].forEach(function(documento){
			
			bodyT += "<tr>";
			bodyT += "<td><input type=\"checkbox\" name=\""+documento.id+"\" value=\""+documento.id+"\" class=\"checkboxes\"></td>"
			bodyT += "<td>"+ documento.dataRegistrazione + "</td>";
			bodyT += "<td>"+ documento.noteIntestazione + "</td>";
			bodyT += "<td>"+ documento.codice + "</td>";
			bodyT += "<td>"+ documento.localita + "</td>";
			bodyT += "<td>"+ documento.indirizzo + "</td>";
			bodyT += "<td>"+ documento.provincia + "</td>";
			bodyT += "<td>"+ documento.cap + "</td>";
			bodyT += "<td>"+ documento.ragSoc1 + "</td>";
			bodyT += "<td>"+ documento.ragSoc2 + "</td>";
			bodyT += "<td>"+ documento.aspetto + "</td>";
			bodyT += "<td>"+ documento.peso + "</td>";
			
			bodyT += "</tr>";
			
			
	});

	bodyT += "</table>";
	table.innerHTML = bodyT;
		}else{
			console.log("insieme pagine vuoto");
		}
	}
	
	async function impaginatore(tipoRegistro){
		
		var listaDocumenti = await getBorderauxBeans(tipoRegistro);
		
		if(listaDocumenti != null){
			
			let form = document.getElementById("formEx");
			form.style.visibility = "visible";
			
			var max=10;
			insiemePagine = new Array();
			
			if(listaDocumenti.length<max){
				pagina = listaDocumenti;
				insiemePagine.push(pagina);
				pagina = new Array();
				
			}else{
			var i;
				for(i = 0;i<listaDocumenti.length;i += max){
					var pagina = new Array();
					pagina = listaDocumenti.slice(i,i+max);
					console.log("pagina "+pagina.length);
					insiemePagine.push(pagina);
				}
				
			}
			
			numberPages();
			
		}
	}
	
	
	async function select(){
		
		tipoRegistro = document.getElementById("cerca").value;

		await impaginatore(tipoRegistro);
		
		tableBuilder();

	}
	
	async function getBorderauxBeans(tipoRegistro) {
		
		var url = window.location.origin;
		url += "/filtra?tipoRegistro="+tipoRegistro;
		
		try{
			
		let response = await fetch(url);
		
		let data = response.json();

		return data;
		} catch {
			console.log("problemi nel prendere le borderaux")
			return null;
		}
	}
	


	function changePage(pval){
		if(pval == 1){
			if(pagSelected != insiemePagine.length){
				pagSelected=parseInt(pagSelected,10) + pval;
				numberPages();
				tableBuilder();
			}
		}
		else if(pval == -1){
			if(pagSelected != 0){
				pagSelected=parseInt(pagSelected + pval,10);
				numberPages();
				tableBuilder();
			}
		}
		
	}
	
	function pageForward(){
		var pval = 1;
		console.log("bottone forward");
		changePage(pval);
	}
	
	function pageBack(){
		var pval = -1;
		console.log("bottone back");
		changePage(pval);
	}
	
	async function genera(){
		let task = "GEN";
		await generaCancella(task);
	}
	
	async function cancella(){
		let task = "CAN";
		await generaCancella(task);
	}
	
	function isCheckedSmt() {
		var values = $('input:checkbox:checked.checkboxes').map(function() {
			return this.value;
		}).get();

		if (values.length == 0) {
			alert("Selezionare almeno una borderaux.");
		} else {
			console.log("vari id= "+values);
			return values;
		}

	}

	async function generaCancella(task){
		values = isCheckedSmt();
		var url = window.location.origin;
		url += "/addBorderaux?";
		let counter =0;
			values.forEach(function(idBor){
				url+= "idBor"+counter+"="+idBor+"&";
				counter++;
			});
		
		if(task == "GEN"){
			url+= "task=GEN";
			console.log(url);
			await fetch(url);
		}
		else if(task=="CAN"){
			url+= "task=CAN";
			console.log(url);
			await fetch(url);
		}
		
		await impaginatore(tipoRegistro);
		
		tableBuilder();
		
	}
	
	function getThemAll(source) {

		var checkboxes = document.getElementsByClassName('checkboxes');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = source.checked;
		}

	}
	
	function numberPages(){
		var insPagView = document.getElementsByClassName("number-pages");
		console.log("numberPages,numero pagine: "+insiemePagine.length);
		counter=0;
		if(insiemePagine != 0){
			var insPagBody = new Array();
			
			if(insiemePagine.length <= 7){
				
				insiemePagine.forEach(function(){
					insPagBody += "<button onclick=\"pageButtonClick()\" id=\""+counter+"\" class=\"pageButtons\">"+(counter+1)+"</button>";
					counter++;
				});
				
				insPagView[0].innerHTML= insPagBody;
				insPagView[1].innerHTML= insPagBody;
				
			} else {
				
				var running = true;
				var i = 0;
				while(running){
					let end = parseInt(insiemePagine.length,10);
					let endMinCurrent = end-parseInt(pagSelected,10);
					let current = parseInt(pagSelected,10);
					
					let oneOfTen = Math.round(parseInt(current/10,10));
					let middle = Math.round(parseInt(current/2,10));
					let oneOfTenCEnd = current+Math.round(parseInt(endMinCurrent/10,10));
					let middleCloseEnd = current+Math.round(parseInt(endMinCurrent/2,10));
					
					console.log("numberPages, end= "+end);
					console.log("numberPages, Current= "+current);
					console.log("numberPages, oneOfTenCEnd= "+oneOfTenCEnd);
					console.log("numberPages, middleCloseEnd= "+middleCloseEnd);
					
					if(i==0||i==6){
						if(i==0){
							insPagBody += "<button onclick=\"pageButtonClick()\" id=\""+0+"\" class=\"pageButtons\">"+1+"</button>";
						}else{
							insPagBody += "<button onclick=\"pageButtonClick()\" id=\""+end+"\" class=\"pageButtons\">"+(end+1)+"</button>";
							running = false;
						}
					}
					else if(i==1||i==5){
						if(i==1){
							insPagBody += "<button onclick=\"pageButtonClick()\" id=\""+(oneOfTen)+"\" class=\"pageButtons\">"+(oneOfTen+1)+"</button>";
						}else{
							insPagBody += "<button onclick=\"pageButtonClick()\" id=\""+(middleCloseEnd)+"\" class=\"pageButtons\">"+(middleCloseEnd+1)+"</button>";
							}
					}
					else if(i==2||i==4){
						if(i==2){
							insPagBody += "<button onclick=\"pageButtonClick()\" id=\""+(middle)+"\" class=\"pageButtons\">"+(middle+1)+"</button>";
						}else{	
							insPagBody += "<button onclick=\"pageButtonClick()\" id=\""+(oneOfTenCEnd)+"\" class=\"pageButtons\">"+(oneOfTenCEnd+1)+"</button>";
							}
					}else if(i==3){
						let insidePBody = parseInt(pagSelected,10)+1;
						insPagBody += "<p style=\"weight:400; -webkit-text-stroke: 2px white;\">"+insidePBody+"</p>";
					}
					
					i++;
				}
					insPagView[0].innerHTML= insPagBody;
					insPagView[1].innerHTML= insPagBody;
				
			}
			
		} else{
			console.log("insiemepagine vuoto");
		}
		
	}
	
	function getText(){
		setPagina(parseInt(document.getElementById("pageInput").value,10)-1);
	}
	
	function setPagina(idNumber){
		console.log("setpagina, idnumber= "+idNumber);
		pagSelected = idNumber;
		numberPages();
		tableBuilder();
	}
	
	function pageButtonClick(){

		$('button.pageButtons').click(function() {
		    setPagina(this.id);
		});
		
	}
	
	
</script>

</head>

<body>

	<div class="btn-menu">
		<form action="/menu">
			<input type="submit" class="btn" value="menu">
		</form>

	</div>

	<div class="search">

		<select class="select" id="cerca" name="tipoRegistro"
			style="width: 40%;">
			<option value="IV">IVA Vendita</option>
			<option value="DV">DDT Vendita</option>
			<option value="LI">Lettere Incarico</option>
		</select>
		<button type="button" value="select" class="btn" onclick="select()">cerca</button>
	</div>


	<div id="formEx">
		<div class="genera-cancella">
			<input type="submit" style="float: right; margin-left: 4%;"
				name="rimuoviBorderspec" value="Cancella" onClick="cancella()">
			<input type="submit" name="generaCsv" value="Genera"
				onclick="genera()">
		</div>
		<div class="border-container">

			<div style="float: right;">
				<input id="pageInput" type="text">
				<button onclick="getText()">Inserisci</button>
			</div>

			<div class="back-forward">
				<button class="switch-pages" onclick="pageBack()">indietro</button>
				<div class="number-pages"></div>
				<button class="switch-pages" onclick="pageForward()">avanti</button>
			</div>

			<div class="container">

				<div id="table"></div>

			</div>
			<div class="back-forward">
				<button class="switch-pages" onclick="pageBack()">indietro</button>
				<div class="number-pages"></div>
				<button class="switch-pages" onclick="pageForward()">avanti</button>
			</div>
		</div>
	</div>
	<script> let form = document.getElementById("formEx");
		 form.style.visibility = "hidden";</script>
</body>
</html>