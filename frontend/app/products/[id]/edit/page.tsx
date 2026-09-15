"use client";

import { use, useEffect, useState } from "react";
import ProductForm from "@/components/ProductForm";
import { productApi } from "@/lib/api";
import { Product, ProductInput } from "@/types/product";

export default function EditProductPage({ params }: { params: Promise<{ id: string }> }) {
  const { id } = use(params); // Next.js 15: route params are now a Promise
  const [product, setProduct] = useState<Product | null>(null);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    productApi
      .getById(Number(id))
      .then(setProduct)
      .catch((err) => setError(err.message));
  }, [id]);

  async function handleUpdate(data: ProductInput) {
    await productApi.update(Number(id), data);
  }

  if (error) return <p className="text-red-600 text-sm">{error}</p>;
  if (!product) return <p className="text-slate-500 text-sm">Loading...</p>;

  return (
    <div>
      <h1 className="text-2xl font-semibold mb-6">Edit Product</h1>
      <ProductForm initial={product} submitLabel="Save Changes" onSubmit={handleUpdate} />
    </div>
  );
}
