import { registerPlugin } from '@capacitor/core';

import type { SysCpuPlugin } from './definitions';

const SysCpu = registerPlugin<SysCpuPlugin>('SysCpu', {
  web: () => import('./web').then(m => new m.SysCpuWeb()),
});

export * from './definitions';
export { SysCpu };
