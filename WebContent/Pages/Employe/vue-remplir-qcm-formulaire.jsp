<!DOCTYPE HTML>
<html>

<head>
  <title>Espace employé</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  <div id="main">
    <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="accueil.aspx"><span class="logo_colour">SONDIX</span></a></h1>
          <h2>DEVISE de l'entreprise</h2>
        </div>
      </div>
      <nav>
        <ul class="sf-menu" id="nav">
          <li class="selected"><a href="accueil.aspx">Accueil</a></li>
          <li><a href="vueEmployeAjouterQcm.aspx">Ajouter Qcm</a></li>
          <li><a href="vueEmployeListeQcm.aspx">Liste Qcm</a></li>
          <li><a href="vueEmployeModifierQcms.aspx">Modifier Qcms</a></li> 
          <li><a href="vueEmployeQcmInternaute.aspx">Qcms Internautes</a></li>
          <li><a href="seDeconnecter.aspx">Quitter</a></li>
        </ul>
      </nav>
    </header>
    <div id="site_content">
 
      <div id="sidebar_container">
        <div class="sidebar">
          <h3>Latest News</h3>
          <h4>New Website Launched</h4>
          <h5>January 1st, 2012</h5>
          <p>2012 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
        </div>
        <div class="sidebar">
          <h3>Useful Links</h3>
          <ul>
            <li><a href="#">First Link</a></li>
            <li><a href="#">Another Link</a></li>
            <li><a href="#">And Another</a></li>
            <li><a href="#">One More</a></li>
            <li><a href="#">Last One</a></li>
          </ul>
        </div>
      </div>
      <div class="content">
      	 <h3>Ajouter un nouveau QCM</h3>
    	<form action="remplirQcm.aspx" method="post" >				
			<input type="hidden" name="etat"    value = "en cours" />
			<input type="hidden" name="idEmp"    value = "${user.id}" />						
			<div >
				<h3>Informations du QCM </h3>
				<p><span>Categorie</span> <label>${ qcm.categorie }</label></p>
				<p><span>Libellé</span> <label>${ qcm.libelle }</label></p>

			</div>
			
          <div class="form_settings">        
    
			<p><span>Tapez la question ${compteurQuestionnaires} du QCM</span><textarea rows="8" cols="50" name="question"></textarea></p>
			<p style="font-weight: bold;">Saisir 4 choix maximum:</p>			
			
			<p><span>Choix A <input class="checkbox" type="checkbox" name="bnrs" value = "0" /></span><textarea rows="6" cols="50" name="choix"></textarea> </p>
			<p><span>Choix B <input class="checkbox" type="checkbox" name="bnrs" value = "1" /></span><textarea rows="6" cols="50" name="choix"></textarea> </p>
			<p><span>Choix C <input class="checkbox" type="checkbox" name="bnrs" value = "2" /></span><textarea rows="6" cols="50" name="choix"></textarea> </p>
			<p><span>Choix D <input class="checkbox" type="checkbox" name="bnrs" value = "3" /></span><textarea rows="6" cols="50" name="choix"></textarea> </p>
		
   
 			<button type="submit" class="submit" name="newQcm" value="questionnaire_suivant">Questionnaire suivant</button>	
			<button type="submit" class="submit"  name="newQcm" value="valider_qcm">Valider Qcm</button>
          </div>
        </form>
      </div>
    </div>
    <footer>
      <p>Copyright &copy; SONDIX | <a href="http://localhost:8080/QCM/">Plateforme QCM en ligne ...</a></p>
    </footer>
  </div>
  <p>&nbsp;</p>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
  <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
  <script type="text/javascript" src="js/image_fade.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
    });
  </script>
</body>
</html>
