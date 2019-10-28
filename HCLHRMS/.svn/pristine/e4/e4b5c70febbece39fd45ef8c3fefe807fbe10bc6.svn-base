<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
<%   Map<String,String> hm=(HashMap)request.getAttribute("Address");
Map<String,String> hm2=(HashMap)request.getAttribute("Mobile");
Map<String,String> hm3=(HashMap)request.getAttribute("Email");
Map<String,String> hm4=(HashMap)request.getAttribute("BankAccount");
Map<String,String> hm5=(HashMap)request.getAttribute("PFNo");
Map<String,String> hm6=(HashMap)request.getAttribute("EsiNo");
Map<String,String> hm7=(HashMap)request.getAttribute("Department");
Map<String,String> hm8=(HashMap)request.getAttribute("Designation");
Map<String,String> hm9=(HashMap)request.getAttribute("WorkLocation");

String LOGINBY=(String)request.getAttribute("LOGINBY");
/* System.out.println("<--->"+LOGINBY); */
/* System.out.println(hm2);
System.out.println(hm3);
System.out.println(hm4);
System.out.println(hm5);
System.out.println(hm6); */
 
%>
<head>
<style>


table td {
    position:relative;
    color:black;
}
.tooltip {
    width:200px;
/*     height:220px; */
    padding:20px;
    border:1px solid #ccc;
 /*    box-shadow: 0 0 3px rgba(0,0,0,.3);
    -webkit-box-shadow: 0 0 3px rgba(0,0,0,.3);
    border-radius:3px; */
 /*    -webkit-border-radius:3px; */
    position:absolute;
    top:5px;
    left:50px;
    display:none;
    color-text:white;
}


</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function(){
    $('.link').hover(
        function(){
            $(this).next().show();
        },
        function(){
            $(this).next().hide();   
        }
    )   
})

</script>
</head>

<body>
<% Iterator it = hm.entrySet().iterator();
Iterator it2 = hm2.entrySet().iterator();
Iterator it3 = hm3.entrySet().iterator();
Iterator it4 = hm4.entrySet().iterator();
Iterator it5 = hm5.entrySet().iterator();
Iterator it6 = hm6.entrySet().iterator();
Iterator it7 = hm7.entrySet().iterator();
Iterator it8 = hm8.entrySet().iterator();
Iterator it9 = hm9.entrySet().iterator();

 int sum=0;
 String busid=null;;
 
 %>
 
 <div>
 <h1 align="center">Employee Pending Details</h1>
<table  style="float: left">

<thead>
<tr>
<th>Personal Details</th>
</tr>
</thead>
    <tr>
        <td>                        
            <a href="#" class="link">Address</a>
            <div class="tooltip"> 
            
            <table> 
            <tr>
            <%
            
            sum=0;
            
            while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    }   
            %>
           </tr>
           
            </table>
            </div>
             </td>
             <td style="width:130px">
        <!--      <form action="ExcelDownload" method="Post"><button type="submit">downl</button></form> -->
        
        <a href="ExcelDownload?type=query1&&name=a.permanentaddress&&LOGINBY=<%=LOGINBY%>"  style='text-decoration:none;' >
        
        <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
        <!-- <button  style="color:green">down</button> --></a>
             </td>
             <td style="width:90px">  <%=sum %></td>
    </tr>
    <tr>
        <td>                        
                                   
            <a href="#" class="link">MobileNo</a>
            <div class="tooltip"> 
            
            <table> 
            <tr>
            <%
            
            sum=0;
            
            while (it2.hasNext()) {
		        Map.Entry pair = (Map.Entry)it2.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } 
		  %>
           </tr>
           
            </table>
            </div>
             </td>
             <td style="width:130px"> <a href="ExcelDownload?type=query1&&name=a.mobile&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' >
                <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
             </td>
             <td> <%=sum %></td>
                   </td>
    </tr>
    <tr>
        <td>                        
            <a href="#" class="link">EmailId</a>
            <div class="tooltip"> 
            <table> 
            <tr>
            <%
            sum=0;
            while (it3.hasNext()) {
		        Map.Entry pair = (Map.Entry)it3.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } %>
           </tr>
            </table>
            </div>
             </td>
              <td> <a href="ExcelDownload?type=query1&&name=a.email&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'>
               <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
              </a></td>
             <td> <%=sum %></td>
         </td>
    </tr>
</table>
<table  style="float: left">
<thead>
<tr>
<th>Other Details</th>
</tr>
</thead>
    <tr>
        <td>                        
            <a href="#" class="link">BankAccountNo</a>
            <div class="tooltip"> 
            
            <table> 
            <tr>
            <%
            
            sum=0;
            
            while (it4.hasNext()) {
		        Map.Entry pair = (Map.Entry)it4.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } %>
           </tr>
            </table>
            </div>
             </td>
              <td style="width:130px"> <a href="ExcelDownload?type=query2&&name=a.accountno&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'>
              <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
              </a></td>
             <td style="width:90px"> <%=sum %></td>
    </tr>
      <tr>
        <td>                        
            <a href="#" class="link">PFNo</a>
            <div class="tooltip"> 
            <table> 
            <tr>
            <%
            sum=0;
            while (it5.hasNext()) {
		        Map.Entry pair = (Map.Entry)it5.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } %>
           </tr>
            </table>
            </div>
             </td>
              <td> <a href="ExcelDownload?type=query2&&name=a.pfno&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'>
               <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
              </td>
             <td> <%=sum %></td>
    </tr>
      <tr>
        <td>                        
            <a href="#" class="link">EsiNo</a>
            <div class="tooltip"> 
            
            <table> 
            <tr>
            <%
            sum=0;
            while (it6.hasNext()) {
		        Map.Entry pair = (Map.Entry)it6.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } %>
           </tr>
            </table>
            </div>
             </td>
              <td > <a href="ExcelDownload?type=query2&&name=a.esino&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' >
               <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
              </a></td>
             <td> <%=sum %></td>
    </tr>
    </table>
    <table  style="float: left">
    <thead>
<tr>
<th>Professional Details</th>
</tr>
</thead>
    <tr>
        <td>                        
            <a href="#" class="link">Department</a>
            <div class="tooltip"> 
            <table> 
            <tr>
            <%
            sum=0;
            while (it7.hasNext()) {
		        Map.Entry pair = (Map.Entry)it7.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } %>
           </tr>
            </table>
            </div>
             </td>
               <td style="width:130px"> <a href="ExcelDownload?type=query3&&name=a.departmentid&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' >
               <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
               </a></td>
             <td> <%=sum %></td>
    </tr>
    <tr>
        <td>                        
            <a href="#" class="link">Designation</a>
            <div class="tooltip"> 
            <table> 
            <tr>
            <%
            sum=0;
            while (it8.hasNext()) {
		        Map.Entry pair = (Map.Entry)it8.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } %>
           </tr>
            </table>
            </div>
             </td>
              <td> <a href="ExcelDownload?type=query3&&name=a.designationid&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' >
              <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' />
              </a></td>
             <td> <%=sum %></td>
    </tr>
    <tr>
        <td>                        
            <a href="#" class="link">WorkLocation</a>
            <div class="tooltip"> 
            <table> 
            <tr>
            <%
            sum=0;
            while (it9.hasNext()) {
		        Map.Entry pair = (Map.Entry)it9.next();
		        sum=sum+Integer.parseInt(pair.getValue().toString());
		        %>
		       <td><%=pair.getKey()+" - "+ pair.getValue()%>
			   </td>
			   <tr>
			    <%
		        //System.out.println(pair.getKey() + " = " + pair.getValue());
		  // it.remove(); // avoids a ConcurrentModificationException
		    } %>
           </tr>
            </table>
            </div>
             </td>
              <td> <a href="ExcelDownload?type=query3&&name=a.worklocationid&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'  >
              <i class="fa fa-download"></i>
               <!-- <img src="Download.jpg"  width='25px' height='25px' style='text-decoration:none;' /> -->
              </a></td>
             <td> <%=sum %></td>
    </tr>
    </table>
</div>
</body>
</html>