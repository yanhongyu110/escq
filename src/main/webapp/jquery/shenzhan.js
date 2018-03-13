function $(element){
return element = document.getElementById(element);
}
function $D(){
var d=$('class1content');
var h=d.offsetHeight;
var maxh=300;
function dmove(){
h+=50; //设置层展开的速度
if(h>=maxh){
d.style.height='260px';
clearInterval(iIntervalId);
}else{
d.style.display='block';
d.style.height=h+'px';
}
}
iIntervalId=setInterval(dmove,2);
}
function $D2(){
var d=$('class1content');
var h=d.offsetHeight;
var maxh=300;
function dmove(){
h-=50;//设置层收缩的速度
if(h<=0){
d.style.display='none';
clearInterval(iIntervalId);
}else{
d.style.height=h+'px';
}
}
iIntervalId=setInterval(dmove,2);
}
function $use(targetid,objN){
var d=$(targetid);
var sb=$(objN);
 if (d.style.display=="block"){
    $D2();
       d.style.display="none";
       sb.innerHTML="展开";
  } else {
    $D();
       d.style.display="block";
       sb.innerHTML='收起';
   }
}