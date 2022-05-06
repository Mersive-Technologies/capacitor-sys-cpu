export interface SysCpuPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getCpuInfo(): Promise<CpuInfo>;
  getZoneTemp( options: {zone: Number}): Promise<{temp: number}>;
}

export interface CpuInfo {
  load: number;
}
