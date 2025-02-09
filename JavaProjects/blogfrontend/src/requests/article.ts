import axios from "axios";
import {ArticleInfo, ArticlePublish} from "@/type/ArticleType";

const articleApplication = axios.create({
    baseURL: '/api/article',
    headers: {
        "Content-Type": "application/json",
    }
})

export const publishArticle = async (article: ArticlePublish): Promise<string> => {
    const response = await articleApplication.post("/publishArticle", {
        articlePublish: article
    })

    return response.data;
}

export const getArticle = async (articleId: number): Promise<ArticleInfo> => {
    const response = await articleApplication.get("/info/".concat(articleId.toString()),)
    return response.data;
}

export const getAllArticles = async (): Promise<ArticleInfo[]> => {
    const response = await articleApplication.get("/info/")
    return response.data;
}