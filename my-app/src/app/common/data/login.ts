export class Login {
    username : string;
    password : string;
    roles: string;
}

export class Client extends Login{
    constructor(username : string =null,
                password : string =null,
                roles : string = "user"){
        super();
        this.username= username;
        this.password= password;
        this.roles= roles;
    }
}
