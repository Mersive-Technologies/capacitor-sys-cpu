import { WebPlugin } from '@capacitor/core';

import type { SysCpuPlugin, CpuInfo } from './definitions';

export class SysCpuWeb extends WebPlugin implements SysCpuPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getCpuInfo(): Promise<CpuInfo> {
    return { load: 0.1 };
  }

  async getZoneTemp(_: { zone: Number; }): Promise<{ temp: number }> {
    return {temp: 0.0};
  }
}
