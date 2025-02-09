/*
    private String username;
    private String password;
    private String email;
 */

export type UserLogin = {
    username: string,
    password: string,
    email: string
}

export type UserRegister = UserLogin & {
    birthday: Date
}

/*
    private Long id;

    private String username;

    private String password;

    private String email;

    private Date createTime;

    private Date updateTime;

    private String firstName;

    private String lastName;

    private Date birth;

    private String selfEvaluation;
 */
export type UserEntity = {
    id: number,
    username: string,
    password: string,
    email: string | null,
    createTime: Date,
    updateTime: Date,
    firstName: string,
    lastName: string,
    birth: Date,
    selfEvaluation: string | null
}