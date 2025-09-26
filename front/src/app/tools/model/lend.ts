import { Employee } from "./employee";
import { Tools } from "./tools";

export interface Lend {
  id: number;
  tool: Tools;
  employee: Employee;
  lendDate: Date;
  returnDate: Date;
}
