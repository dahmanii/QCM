<!DOCTYPE HTML>
<html>

<head>
  <title>CSS3_seascape</title>
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
          <h1><a href="index.aspx"><span class="logo_colour">SONDIX</span></a></h1>
          <h2>DEVISE de l'entreprise</h2>
        </div>
      </div>
      <nav>
        <ul class="sf-menu" id="nav">
          <li class="selected"><a href="index.aspx">Accueil</a></li>
          <li><a href="vueSeConnecter.aspx">Se connecter</a></li>
          <li><a href="vueNouveauUtilisateur.aspx">S'enregistrer</a></li>
          <li><a href="about.aspx">About</a></li>
          
          <li><a href="contact.php">Contact Us</a></li>
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
        <h3>Créer nouveau compte</h3>
        <form action="nouveauUser.aspx" method="post">
          <div class="form_settings">        
            <p>
            	<span>Choisir fonction </span>
	            <select id="id" name="role">
	            	<option value="Employe">Employé</option>							
					<option value="Responsable">Responsable technique</option>
				    <option value="Internaute">Internaute</option>
	            </select>
            </p>     
			<p><span>Nom</span><input type="text" name="nom" value="" /></p>
			<p><span>Prénom</span><input type="text" name="prenom" value="" /></p>
			<p><span>Date de naissance</span><input type="text" name="dateNaissance" value="" /></p>
            <p><span>Login</span><input type="text" name="identifiant" value="" /></p>
            <p><span>Mot de pass</span><input type="password" name="password" value="" /></p>     
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="valider" value="valider" /></p>
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
