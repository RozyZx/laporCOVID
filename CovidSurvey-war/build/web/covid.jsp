<%-- 
    Document   : covid
    Created on : Jun 8, 2020, 9:01:53 AM
    Author     : RozyZzx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<h:head><title>Covid UAS</title>
<link href="./css/styles.css" rel="stylesheet" type="text/css"/> 
</h:head>
    <body
        <%
            if((String)request.getAttribute("stat") == "yes") out.println(" onload=\"done()\" ");
        %>
        >
        <div class="bg">
            <div class="topnav" id="myTopnav">
                <a href="index.html">Home</a>
                <a href="#" class="active">Covid Task</a>
                <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                    <i class="fa fa-bars"></i>
                </a>
            </div>
            <div class="content">
                <div class="card" id="surveycard">
                    <div class="container">
                        <center>
                            <h2 class="no-margin">Pelaporan kasus Covid 19</h2>
                            <hr />
                            <p />
                        </center>
                        <form id="myForm" method="post" action="SurveyServlet">
                            <table style="width: 100%;">
                                <tbody>
                                    <tr><td><br/></td></tr>
                                    <tr><td>Nama Lengkap</td></tr>
                                    <tr><td><input type="text" name="n0" class="input" placeholder="Nama Lengkap" maxlength="32" title="Maksimal 32 karakter" required/></td></tr>
                                    
                                    <tr><td><br/></td></tr>
                                    <tr><td>Identitas</td></tr>
                                    <tr>
                                        <td><table>
                                            <tr><td style="width: 30%;">
                                                    <select name="i0" class="input" style="padding: 10px;">
                                                        <option value="nik">NIK</option>
                                                        <option value="kmahasiswa">Kartu Mhs</option>
                                                    </select>
                                                </td>
                                                <td style="width: 70%;"><input type="text" name="i1" class="input" placeholder="Nomor Identitas" pattern="[0-9]{16}" maxlength="16" title="16 digit angka" required/></td></tr>
                                        </table></td>
                                    </tr>
                                    
                                    <tr><td><br/></td></tr>
                                    <tr><td>Alamat</td></tr>
                                    <tr><td><input type="text" name="a0" class="input" placeholder="Alamat" maxlength="64" title="Maksimal 64 karakter" required/></td></tr>
                                    <tr>
                                        <td><table>
                                            <tr><td style="width: 50%;"><input type="text" name="a1" class="input" placeholder="Kota" maxlength="20" title="Maksimal 20 karakter" required/></td>
                                                <td style="width: 50%;"><input type="text" name="a2" class="input" placeholder="Kode Pos" pattern="[0-9]{5}" title="5 digit angka" required/></td></tr>
                                            </table></td>
                                    </tr>
                                    
                                    <tr><td><br/></td></tr>
                                    <tr><td>Kontak</td></tr>
                                    <tr>
                                        <td><table>
                                            <tr><td style="width: 50%;"><input type="text" name="k0" class="input" placeholder="Nomor Telp" pattern="[0-9]{10,}" maxlength="13" title="10 hingga 13 digit angka" required/></td>
                                                <td style="width: 50%;"><input type="text" name="k1" class="input" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="email tidak valid" required/></td></tr>
                                            </table></td>
                                    </tr>
                                    
                                    <tr><td><br/></td></tr>
                                    <tr><td>Suspek</td></tr>
                                    <tr><td><input type="text" name="s0" class="input" placeholder="Nama Suspek yang Menularkan" maxlength="32" title="Maksimal 32 karakter" required/></td></tr>
                                    <tr>
                                        <td><table>
                                            <tr><td style="width: 50%;"><input type="text" name="s1" class="input" placeholder="Lokasi bertemu suspek" maxlength="32" title="Maksimal 32 karakter"/></td>
                                                <td style="width: 50%;"><input type="text" onfocus="(this.type='date')" name="s2" class="input" placeholder="Tanggal bertemu suspek"/></td></tr>
                                            </table></td>
                                    </tr>
                                    
                                    <tr><td><br/></td></tr>
                                    <tr><td>Gejala COVID-19 yang anda alami</td></tr>
                                    <tr><td>
                                            <textarea class="input" style="width: 100%; resize: none;" name="g0" rows="5" cols="50" maxlength="256" wrap="soft" required></textarea>
                                        </td></tr>
                                    
                                    <tr><td><br/></td></tr>
                                    <tr>
                                        <td><table>
                                                <tr><td><input type="button" value="Cancel" onclick="ccl()" class="input" style="font-weight: bold;"/></td>
                                                    <td><input type="submit" value="Submit" class="input" style="background-color: #03dbfc;color: white; font-weight: bold;"/></td></tr>
                                            </table></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function done(){
                alert("Data berhasil disimpan");
            } 
            function ccl() {
                if(confirm("Delete entries?")) document.getElementById("myForm").reset();
            }
            function myFunction() {
                var x = document.getElementById("myTopnav");
                if (x.className === "topnav") {
                    x.className += " responsive";
                } else {
                    x.className = "topnav";
                }
            }
        </script>	
</body>
</html>
