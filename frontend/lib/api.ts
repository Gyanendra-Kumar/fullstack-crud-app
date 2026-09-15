import { Product, ProductInput } from "@/types/product";
import { Category } from "@/types/category";

const BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL ?? "http://localhost:8080/api";

/**
 * A single place responsible for talking to the backend (Single
 * Responsibility). Components never call fetch() directly — they call
 * these functions. If you swap REST for GraphQL someday, only this file
 * changes.
 */
async function request<T>(path: string, options?: RequestInit): Promise<T> {
  const res = await fetch(`${BASE_URL}${path}`, {
    headers: { "Content-Type": "application/json" },
    cache: "no-store",
    ...options,
  });

  if (!res.ok) {
    const body = await res.json().catch(() => ({}));
    throw new Error(body.message || `Request failed: ${res.status}`);
  }

  // 204 No Content (DELETE) has no body to parse
  if (res.status === 204) return undefined as T;

  return res.json() as Promise<T>;
}

export const productApi = {
  getAll: () => request<Product[]>("/products"),
  getById: (id: number) => request<Product>(`/products/${id}`),
  create: (data: ProductInput) =>
    request<Product>("/products", { method: "POST", body: JSON.stringify(data) }),
  update: (id: number, data: ProductInput) =>
    request<Product>(`/products/${id}`, { method: "PUT", body: JSON.stringify(data) }),
  remove: (id: number) => request<void>(`/products/${id}`, { method: "DELETE" }),
};

export const categoryApi = {
  getAll: () => request<Category[]>("/categories"),
};
