export interface SysCpuPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getCpuInfo(): Promise<CpuInfo>;
  getOnlineCpus(): Promise<OnlineInfo>;
  getZoneTemp( options: {zone: Number}): Promise<{temp: number}>;
}

export interface OnlineInfo {
  online: string;
}

export interface CpuInfo {
  load: number;
}
