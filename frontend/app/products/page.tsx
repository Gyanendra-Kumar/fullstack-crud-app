"use client";

import { useEffect, useState } from "react";
import { Product } from "@/types/product";
import { productApi } from "@/lib/api";
import ProductTable from "@/components/ProductTable";

export default function ProductsPage() {
  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  async function load() {
    try {
      setLoading(true);
      setProducts(await productApi.getAll());
    } catch (err) {
      setError(err instanceof Error ? err.message : "Failed to load products");
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    load();
  }, []);

  async function handleDelete(id: number) {
    if (!confirm("Delete this product?")) return;
    await productApi.remove(id);
    setProducts((prev) => prev.filter((p) => p.id !== id));
  }

  return (
    <div>
      <h1 className="text-2xl font-semibold mb-6">Products</h1>
      {loading && <p className="text-slate-500 text-sm">Loading...</p>}
      {error && <p className="text-red-600 text-sm mb-4">{error}</p>}
      {!loading && !error && <ProductTable products={products} onDelete={handleDelete} />}
    </div>
  );
}
