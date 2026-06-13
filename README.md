# template-cljfx

Production-grade [cljfx](https://github.com/cljfx/cljfx) desktop application template.

## Features

- **cljfx** — declarative, functional JavaFX wrapper
- **Malli** — boundary-crossing schema contracts
- **clj-kondo** — zero-warning linting with optional linters enabled
- **kaocha** — unit + integration + e2e test suites
- **GitHub Actions** — lint, test (all suites), and uberjar build workflows

## Namespace Architecture

| Category | Purpose |
|---|---|
| `domain.*` | Pure business logic. No I/O. |
| `infra.*` | Effectful layer (filesystem, prefs, events). |
| `shape.*` | Pure structure morphisms over data. No domain policy. |
| `law.*` | Malli schemas + contract validators. No I/O. |
| `ui.*` | cljfx component descriptions (pure data). |

## Setup

```bash
clojure -T:build uberjar
```

## Running Tests

```bash
# all suites
clojure -M:test

# unit only
clojure -M:test unit

# integration only
clojure -M:test integration

# e2e only
clojure -M:test e2e
```

## Lint

```bash
clj-kondo --lint src test
```

## License

Copyright © 2026 — EPL-2.0
