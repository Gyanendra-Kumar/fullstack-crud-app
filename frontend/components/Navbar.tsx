import Link from "next/link";

export default function Navbar() {
  return (
    <nav className="border-b border-slate-200 bg-white">
      <div className="mx-auto flex max-w-5xl items-center justify-between px-4 py-3">
        <Link href="/" className="font-semibold text-slate-900">
          Inventory
        </Link>
        <div className="flex gap-4 text-sm">
          <Link href="/products" className="text-slate-600 hover:text-slate-900">
            Products
          </Link>
          <Link
            href="/products/new"
            className="rounded-md bg-slate-900 px-3 py-1.5 text-white hover:bg-slate-700"
          >
            + New Product
          </Link>
        </div>
      </div>
    </nav>
  );
}
