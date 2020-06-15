
function validate()
{
    let name=document.getElementById("user")
    let pass=document.getElementById("pass")
    
    var reg= /^([a-zA-Z0-9\.-]+)@([a-zA-Z0-9-]+).([a-z]{2,8})(.[a-z]{2,8})?$/;

    if(name.value==""&&pass.value=="")
    {
        alert("user and pass blank value not allowed!!")
        return false;
    }
    else if(name.value.trim()=="")
    {
        alert("user blank vlaue not allowed!")
        return false;
    }
    else if(pass.value=="")
    {
        alert("password blank vlaue not allowed!")
        return false;
    }
    else if(!reg.test(pass.trim()))
    {
    	alert("email is not valid!");
    	return false;
    }
    else 
    {
        return true;
    }
    
}