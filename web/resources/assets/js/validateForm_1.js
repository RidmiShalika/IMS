/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$().ready(function(){
    console.log("ready for validation.....");
    
    $("#signinForm").validate({
        rules:{
            userName: "required"
   
        },
        
        messages:{
            userName: "please Enter the name"
        }
    });
});    
   
    