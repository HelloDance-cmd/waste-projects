var Switch;
(function (Switch) {
    Switch[Switch["Chinese"] = 1] = "Chinese";
    Switch[Switch["Mathematic"] = 2] = "Mathematic";
    Switch[Switch["SimpleChinese"] = 4] = "SimpleChinese";
})(Switch || (Switch = {}));
var switches = Switch.Chinese | Switch.SimpleChinese;
var hasSubject = function (subject, hasIt) { return (subject & hasIt) == 0; };
console.log(hasSubject(switches, Switch.Chinese));
