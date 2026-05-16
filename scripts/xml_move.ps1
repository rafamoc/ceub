# Caminho base onde estão as pastas dos alunos
$basePath = "Entrega02"

# Função para normalizar o nome do arquivo
function Normalize-FileName {
    param ([string]$name)
    
    # Remove acentos e converte para minúsculas
    $normalized = $name.Normalize([Text.NormalizationForm]::FormD) `
        -replace '\p{M}', '' `
        -replace '[^a-zA-Z0-9\s]', '' `
        -replace '\s+', '_' `
        -replace '_+', '_'

    return $normalized.ToLower()
}

# Pega todas as pastas dentro do caminho base
$folders = Get-ChildItem -Path $basePath -Directory

foreach ($folder in $folders) {
    # Extrai o nome do aluno (antes do primeiro "_")
    $studentName = ($folder.Name -split "_")[0]

    # Normaliza o nome conforme regras do Android Studio
    $cleanName = Normalize-FileName $studentName

    # Encontra os arquivos XML dentro da pasta
    $xmlFiles = Get-ChildItem -Path $folder.FullName -Filter "*.xml"

    foreach ($xml in $xmlFiles) {
        # Define o novo nome e caminho do XML renomeado
        $newName = "$cleanName.xml"
        $newPath = Join-Path $folder.FullName $newName

        # Renomeia o arquivo dentro da pasta
        Rename-Item -Path $xml.FullName -NewName $newName -Force
        Write-Host "Renomeado: $($xml.Name) -> $newName"

        # Caminho de destino no diretório pai
        $destination = Join-Path $basePath $newName

        # Copia o arquivo renomeado para o diretório base
        Copy-Item -Path $newPath -Destination $destination -Force
        Write-Host "Copiado para: $destination"
    }
}