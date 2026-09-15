"use client";

import Link from "next/link";
import { Product } from "@/types/product";

interface Props {
  products: Product[];
  onDelete: (id: number) => void;
}

export default function ProductTable({ products, onDelete }: Props) {
  if (products.length === 0) {
    return <p className="text-slate-500 text-sm">No products yet. Add your first one.</p>;
  }

  return (
    <table className="w-full text-sm border-collapse">
      <thead>
        <tr className="border-b border-slate-200 text-left text-slate-500">
          <th className="py-2 pr-4">Name</th>
          <th className="py-2 pr-4">Category</th>
          <th className="py-2 pr-4">Price</th>
          <th className="py-2 pr-4">Qty</th>
          <th className="py-2 pr-4"></th>
        </tr>
      </thead>
      <tbody>
        {products.map((p) => (
          <tr key={p.id} className="border-b border-slate-100">
            <td className="py-2 pr-4 font-medium">{p.name}</td>
            <td className="py-2 pr-4 text-slate-600">{p.category?.name}</td>
            <td className="py-2 pr-4">${p.price.toFixed(2)}</td>
            <td className="py-2 pr-4">{p.quantity}</td>
            <td className="py-2 pr-4 text-right space-x-3">
              <Link href={`/products/${p.id}/edit`} className="text-slate-700 hover:underline">
                Edit
              </Link>
              <button
                onClick={() => onDelete(p.id)}
                className="text-red-600 hover:underline"
              >
                Delete
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
