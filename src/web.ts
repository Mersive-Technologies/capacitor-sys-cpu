import { WebPlugin } from '@capacitor/core';

import type { SysCpuPlugin } from './definitions';

export class SysCpuWeb extends WebPlugin implements SysCpuPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
