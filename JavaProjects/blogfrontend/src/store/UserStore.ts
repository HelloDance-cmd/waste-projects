import {defineStore} from "pinia";
import {UserEntity} from "@/type/UserType";

const userStore = defineStore('userStore', {
    state() {
        return {
            userInformation: {}
        }
    },
    actions: {
        setUserInformation(userInformation: UserEntity) {
            this.userInformation = userInformation;
        }
    }
})

export default userStore;