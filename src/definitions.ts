export interface SysCpuPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getCpuInfo(): Promise<CpuInfo>;
}

export interface CpuInfo {
  load: number;
}
