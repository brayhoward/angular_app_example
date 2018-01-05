// Data models
export interface Service {
  name: String,
  id?: number | String,
  total: number,
  totalParts: number,
  totalLabor: number,
  parts: Part[],
  labor: Labor[]
}
export interface Part {
  description: String,
  number: String,
  price: number,
  quantity: number,
  extendedPrice: number,
  category?: String,
  type?: String,
  id?: number | String
}
export interface Labor {
  description: String,
  price: number,
  id?: number | String
}

export default Service;