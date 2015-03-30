<%-- 
    Document   : index
    Created on : Jul 6, 2014, 10:57:38 PM
    Author     : AA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style type="text/css">
    #apDiv1 {
	position: absolute;
	width: 840px;
	height: 100px;
	z-index: 1;
	left: 108px;
	top: 4px;
}
    #apDiv2 {
	position: absolute;
	width: 841px;
	height: 41px;
	z-index: 2;
	left: 110px;
	top: 106px;
}
    #apDiv3 {
	position: absolute;
	width: 453px;
	height: 342px;
	z-index: 3;
	left: 111px;
	top: 159px;
}
    #apDiv4 {
	position: absolute;
	width: 378px;
	height: 339px;
	z-index: 4;
	left: 572px;
	top: 162px;
}
    #apDiv5 {
	position: absolute;
	width: 841px;
	height: 115px;
	z-index: 5;
	left: 111px;
	top: 509px;
}
    </style>
    <link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
    <script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
    </head>
    <body>
    <div id="apDiv1"><img src="images/header.jpg" width="839" height="98" alt="header"></div>
    <div id="apDiv2">
      <form name="form2" method="post" action="checkOffer">
        <table width="838" height="41" border="1">
          <tr>
            <td width="347"><label>Mobile number:</label>&nbsp;<span id="sprytextfield4">
              <label for="mobileNo"></label>
              <input type="text" name="mobileNo" id="mobileNo">
            <span class="textfieldRequiredMsg">Mobile Number is required.</span></span></td>
            <td width="95"><input type="submit" name="checkOffer" id="checkOffer" value="Check Offer"></td>
            <td width="374" id="offerMsg">
                <% 
                    if(request.getAttribute("offerMsg")!=null){
                        out.println(request.getAttribute("offerMsg"));
                    }
                %>
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div id="apDiv3"><img src="images/content.jpg" width="396" height="307"></div>
    <div id="apDiv4">
      <form name="form1" method="post" action="register">
        <table width="377" height="273" border="1">
          <tr>
            <td width="119">&nbsp;</td>
            <td width="242"><img src="images/register.jpg" width="240" height="40"></td>
          </tr>
          <tr>
            <td><label>Name</label>&nbsp;</td>
            <td><span id="sprytextfield1">
              <label for="name"></label>
              <input type="text" name="name" id="name">
            <span class="textfieldRequiredMsg">Name is required.</span></span></td>
          </tr>
          <tr>
            <td><label>Email</label>&nbsp;</td>
            <td><span id="sprytextfield2">
              <label for="email"></label>
              <input type="text" name="email" id="email">
            <span class="textfieldRequiredMsg">Email is required.</span></span></td>
          </tr>
          <tr>
            <td><label>Mobile Number</label>&nbsp;</td>
            <td><span id="sprytextfield3">
              <label for="mobile"></label>
              <input type="text" name="mobile" id="mobile">
            <span class="textfieldRequiredMsg">Mobile Number is required.</span></span></td>
          </tr>
          <tr>
            <td><input type="submit" name="register" id="register" value="Register"></td>
            <td id="registerMsg">
                <% 
                    if(request.getAttribute("registerMsg")!=null){
                        out.println(request.getAttribute("registerMsg"));
                    }
                %>
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div id="apDiv5"><img src="images/print-footer.gif" width="840" height="120" alt="footer"></div>
    <script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1");
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2");
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytextfield3");
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytextfield4");
    </script>
    </body>
</html>
