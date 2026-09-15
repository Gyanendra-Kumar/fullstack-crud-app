import Link from "next/link";

export default function Home() {
  return (
    <div className="text-center py-20">
      <h1 className="text-3xl font-semibold mb-4">Inventory Manager</h1>
      <p className="text-slate-600 mb-6">
        A learning app demonstrating full CRUD against a Spring Boot + MySQL backend.
      </p>
      <Link
        href="/products"
        className="inline-block rounded-lg bg-slate-900 px-5 py-2.5 text-white hover:bg-slate-700 transition"
      >
        View Products
      </Link>
    </div>
  );
}
