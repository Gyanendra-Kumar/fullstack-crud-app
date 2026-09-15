"use client";

import ProductForm from "@/components/ProductForm";
import { productApi } from "@/lib/api";

export default function NewProductPage() {
  return (
    <div>
      <h1 className="text-2xl font-semibold mb-6">New Product</h1>
      <ProductForm submitLabel="Create Product" onSubmit={(data) => productApi.create(data).then(() => {})} />
    </div>
  );
}
