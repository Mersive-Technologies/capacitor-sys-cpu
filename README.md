# capacitor-sys-cpu

Capacitor plugin for obtaining system CPU utilization.

## Install

```bash
npm install capacitor-sys-cpu
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getCpuInfo()`](#getcpuinfo)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getCpuInfo()

```typescript
getCpuInfo() => Promise<CpuInfo>
```

**Returns:** <code>Promise&lt;<a href="#cpuinfo">CpuInfo</a>&gt;</code>

--------------------


### Interfaces


#### CpuInfo

| Prop       | Type                |
| ---------- | ------------------- |
| **`load`** | <code>number</code> |

</docgen-api>
