# 🧱 ItemBuilder (Spigot API)

Crie `ItemStacks` no Spigot de forma rápida, poderosa e a partir de **strings simples e expressivas**. Perfeito para plugins customizados, sistemas de menus, ou configurações por arquivo!

---

## 📦 Instalação via JitPack

Adicione o repositório JitPack e a dependência no seu `build.gradle`:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.theprogmatheus:ItemBuilder:1.0.0' // substitua pela última versão
}
```

---

## 🛠️ Como usar

```java
ItemStack item = new ItemBuilder("DIAMOND_SWORD 1 sharpness:5 name:§6Excalibur lore:§7A_espada_lendária_glow").toItemStack();
```

Simples assim. E funciona direto com strings lidas de `config.yml`!

---

## 🧪 Sintaxe da String

### 🧱 Material, Data e Quantidade

```
[MATERIAL[:DATA]] [QUANTIDADE]
```

Exemplos:
- `"STONE"` → Pedra
- `"WOOL:14 32"` → 32 lãs vermelhas
- `"DIAMOND_SWORD 1"` → 1 espada de diamante

---

## ✨ Atributos Suportados

Após o material e quantidade, você pode encadear atributos:

### 🎯 Encantamentos (`ItemEnchant`)

```
[ENCANTAMENTO]:[NÍVEL]
```

- `sharpness:5` → Afiada V
- `unbreaking:3` → Inquebrável III
- `fire_aspect:2` → Aspecto Flamejante II

### 🧠 Nome (`ItemName`)

```
name:[NOME]
```

- `name:§bEspada_Lendária` → Define o nome com cor.

### 📜 Lore (`ItemLore`)

```
lore:[TEXTO]
```

Adiciona uma linha à lore.

- `lore:§7Feita_por_Matheus`
- Pode repetir várias vezes para múltiplas linhas.

### 💥 Efeitos de Poção (`ItemEffect`)

```
[EFEITO]:[NÍVEL]-[DURAÇÃO]
```

- `speed:2-60` → Velocidade II por 60s
- `strength:1-30` → Força I por 30s  

### 💀 Cabeças de Jogador (`ItemSkull`)

```
skull:[NOME_DO_JOGADOR]
```

- `skull:Matheus` → Cabeça do jogador Matheus

### 🌐 Cabeça por URL (`ItemSkullUrl`)

```
skullurl:[URL_TEXTURE]
```

- `skullurl:http://textures.minecraft.net/texture/...` → Cabeça com textura customizada

### 🌟 Glow (`ItemGlow`)

```
glow:true
```

Adiciona brilho ao item mesmo sem encantamentos.

---

## 🔗 Exemplo completo

```java
new ItemBuilder(
  "DIAMOND_CHESTPLATE 1 protection:4 unbreaking:3 name:§bPeitoral_Divino lore:§7Forjado_no_céu speed:1-120 glow"
).toItemStack();
```

---

## 📄 Licença

MIT © [Matheus Aguiar](https://github.com/theprogmatheus)
