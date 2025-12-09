b2CLickCount = 0;

b1 = document.querySelector("#b1")
b2 = document.querySelector("#b2")
document.querySelector("#b3").onclick = () => {
    console.log("b3~~~~```");
}


b1.addEventListener("click", function() {
    console.log("clicked1");
    console.log("clicked2");
    console.log("clicked3");
})


b2.addEventListener("click", function() {
    b2CLickCount += 1;

    console.log(`b2 点了 ${b2CLickCount} 次`);
})

