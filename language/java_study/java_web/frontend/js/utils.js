function add(a, b) {
    return a + b;
}

function multiply(a, b) {
    return a * b;
}

let user = {
    name: 'tom',
    age: 18,
    gender: 'Male',
    sing() {
        console.log(`${this.name} 唱着最炫的民族风`)
    },
    dance() {
        console.log(`${this.name} 动次大次`)
    }
}

console.log(JSON.parse(JSON.stringify(user)));

user.dance();
user.sing();


