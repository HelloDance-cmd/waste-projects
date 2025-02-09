export interface Article {
  // id: number | string;
  title: string;
  content: string;
  authorId: number;
  createTime: number; // 时间戳
  updateTime: number;
  categoryId: number;
  views: number | 0;
}

// import { faker } from "@faker-js/faker";

// export const generateMockArticles = (count: number): Article[] => {
//   const articles: Article[] = [];
//   for (let i = 0; i < count; i++) {
//     articles.push({
//       id: i + 1,
//       title: faker.lorem.sentence(),
//       content: faker.lorem.paragraphs(),
//       authorId: 1,
//       createTime: faker.date.past().getTime(),
//       updateTime: faker.date.recent().getTime(),
//       categoryId: 1,
//       views: 1,
//     });
//   }
//   return articles;
// };
