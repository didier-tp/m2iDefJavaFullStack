export class Login {
    username : string;
    password : string;
    roles: string;
}

export class AuthResponse{
    token :string;
	message : string;
	ok:boolean;
}

export class Client extends Login{
    numero : number = null;
    
    constructor(username : string =null,
                password : string =null,
                roles : string = "user"){
        super();
        this.username= username;
        this.password= password;
        this.roles= roles;
    }
}
