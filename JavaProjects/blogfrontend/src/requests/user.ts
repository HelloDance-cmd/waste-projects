import axios from "axios";
import {UserEntity, UserLogin, UserRegister} from "@/type/UserType";

const userApplication = axios.create({
    baseURL: "/api/user",
    headers: {
        "Content-Type": "application/json"
    }
})

/**
 * Use this interface for login
 * @param user
 */
export const login = async (user: UserLogin): Promise<string> => {
    const response = await userApplication.post("/login", {
        user
    });

    return response.data;
}
/**
 * Use this interface for get user's information, return type is an entity in Database
 * @param userId
 */
export const userInfo = async (userId: number): Promise<UserEntity> => {
    const response = await userApplication.post("/info")
    return response.data;
}

/**
 * Use this interface for register a user
 * @param user
 */
export const register = async (user: UserRegister): Promise<string> => {
    const response = await userApplication.post("/register")
    return response.data;
}