export interface SysCpuPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
