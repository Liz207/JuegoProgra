# JuegoProgra

<!-- local-development:start -->
## Desarrollo local

Consulta [RUNNING.md](RUNNING.md) para ubicar cada componente, abrirlo en su IDE, compilarlo y conocer las comprobaciones realizadas y los requisitos pendientes.
<!-- local-development:end -->

<!-- build-repairs-20261115:start -->
## Reparación y comprobación — 2026-11-15

- Se corrigieron los nombres de Razas/Armas, imports de Bestia/Orco y un acceso Systemda inválido.
- Bestia implementa la descripción de habilidad requerida por Personaje.

Comprobado:

- Compila con Ant.
- SmokePersonajes verificó ataque con puños, daño propio, sanación de un solo uso y razas.

Comandos:

```powershell
.\build-local.ps1
.\test-local.ps1
```

Alcance pendiente:

- El guardado de partidas y las estadísticas dependen de la configuración PostgreSQL del ejercicio.

<!-- build-repairs-20261115:end -->
