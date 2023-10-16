import {Controller, Get} from "@nestjs/common";

@Controller('/api/v1')
export class AppController  {
    @Get("/users")
    getUsers() {
        return [{id: 1, name: "Sergey", email: "a@a.a"}];
    }
}