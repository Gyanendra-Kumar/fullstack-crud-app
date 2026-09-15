import { Category } from "./category";

// What the API returns
export interface Product {
  id: number;
  name: string;
  description: string | null;
  price: number;
  quantity: number;
  category: Category;
  createdAt: string;
  updatedAt: string;
}

// What we send when creating/updating (mirrors ProductRequestDTO on the backend)
export interface ProductInput {
  name: string;
  description: string;
  price: number;
  quantity: number;
  categoryId: number;
}
