import("fs")


const log = console.log.bind(console);
const $ = document.getElementById.bind(document);

document.addEventListener('load', function () {
  log("Report data that a bug is occurs");
  const occurs = $("occurs");
  document.addEventListener("click", occurs.click);
})
