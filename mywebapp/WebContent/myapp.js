function validate(){
    if(document.getElementById("user").value){
        return true;
    }
    else{
        document.getElementById("err").innerHTML="User needed!";
        document.getElementById("err").style.color="red";
        document.forms["f1"].submit();
        return false;
    }
}





/*console.log("hello javascript");

console.log(a); //undefined
//console.log(c); //error
// console.log(b); //function object

//var a = 'hello';
console.log(a);
var a = 0;
var funcRef ;
function b(){ //defined inside global scope
//    console.log("I'm inside a function");
//    console.log(a);
//    var temp = 1;
//    function c(){
//        console.log(a);
//        console.log(temp);
//    }
// c() ;  
    if(a){
        console.log("a exists");
    }
    else{
        console.log("a doesn't eval to true");
    }
    //funcRef = c;
    var x = function(){
        console.log("Anonymous func");
    }
    console.log(x);
    //return x;
}
//b();
//funcRef(); 
//var a = "hello";
//c(); //error
var myfunc = b; //myfunc is a pointer to b
myfunc();
//b();*/




/*function a(param1,param2){ //'undefined' is the default value of parameters
   param1 = param1 || "default for param1";
    console.log(param1);
    console.log(param2);
}

a("test");
a();      */ 