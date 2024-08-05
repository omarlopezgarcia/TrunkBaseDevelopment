# 🌳 Trunk Based Development

## Estructura de Ramas

### 🏠 Rama Principal (Trunk):

| Rama       | Descripción                                                                                  |
|------------|----------------------------------------------------------------------------------------------|
| **main o trunk** | Es la rama principal donde reside el código listo para producción. Todos los cambios importantes deben integrarse aquí, preferiblemente con versiones completamente funcionales y probadas. |

### 🌟 Ramas de Funcionalidad (Feature Branches):
| Rama                          | Descripción                                                                                  | Ejemplo                         |
|-------------------------------|----------------------------------------------------------------------------------------------|---------------------------------|
| **feature/<nombre-funcionalidad>** | Se crean para desarrollar nuevas funcionalidades, mejoras o cambios significativos. Deben ser de corta duración y se deben fusionar en la rama principal una vez que el trabajo esté completo y probado. | `feature/vg-ms-communion` |


## 🛠️ Buenas Prácticas

### ✍️ Commits:
- A preferencia los commits deben ser compactos, descriptivos y entendibles para facilitar la revisión y el seguimiento de cambios.
- Los mensajes de commit deben ser precisos de lo que se desarrolló.

### 🔍 Code Review:
- Implementar un proceso de revisión de código para cada cambio que se fusione en la rama principal.
- Ayuda a mantener la calidad del código y evitar la redundancia.

### 🔗 Política de los Merge's:
- Fomentar la fusión de ramas mediante los pull requests (PRs).
- Según las buenas prácticas las ramas deben fusionarse en main sólo después de pasar todas las pruebas y recibir la aprobación del product owner (siendo tu developer).
