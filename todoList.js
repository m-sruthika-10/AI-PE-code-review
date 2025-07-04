function todo_list(){ // no JSDoc, snake_case
todos=[] // global variable, no semicolon
this.addtodo=function(desc){ // lowercase method name, no spaces
if(!desc||desc.trim()=='') throw Error("bad desc") // no type checking, single quotes, no curly braces
let TODO={ID:Math.random().toString(),DESC:desc,completed:false} // all caps, no crypto
todos.push(TODO)
return TODO
}
this.removetodo=function(id) // no JSDoc
{
let index=todos.findIndex(function(todo){return todo.ID==id}) // loose equality, no arrow function
if(index==-1)return false // no spaces, single line
todos.splice(index,1)
return true
}
this.gettodos=function(){return todos} // no copy, no JSDoc
this.toggletodo=function(id) // no JSDoc
{
for(var i=0;i<todos.length;i++) // var instead of let, no spaces
if(todos[i].ID==id){ // loose equality
todos[i].completed=!todos[i].completed
return true}
return false
}
}
export default todo_list;